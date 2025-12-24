#!/bin/bash
# Script to build image for qemu.
# Author: Siddhant Jajoo.

set -e

git submodule init
git submodule sync
git submodule update

# Setup Yocto environment
source poky/oe-init-build-env

# 🚨 CRITICAL: disable bitbake server BEFORE ANY bitbake command
export BB_NO_SERVER=1

# Kill stale server artifacts (CI safety)
bitbake -m || true
rm -f tmp/bitbake.lock tmp/bitbake.sock

CONFLINE='MACHINE = "qemuarm64"'

if ! grep -q "${CONFLINE}" conf/local.conf; then
    echo "Append ${CONFLINE} in the local.conf file"
    echo ${CONFLINE} >> conf/local.conf
else
    echo "${CONFLINE} already exists in the local.conf file"
fi

# Safe now because BB_NO_SERVER=1 is already active
if ! bitbake-layers show-layers | grep -q "meta-aesd"; then
    echo "Adding meta-aesd layer"
    bitbake-layers add-layer ../meta-aesd
else
    echo "meta-aesd layer already exists"
fi

# Build
bitbake core-image-aesd

