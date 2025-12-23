SUMMARY = "AESD Socket Server"
DESCRIPTION = "Multithreaded socket server with timestamp support"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0+git${SRCPV}"

# ================================
# Source repository (Assignment 3)
# ================================
SRC_URI = "git://github.com/siddjove/assignments-3-and-later-siddjove2.git;protocol=https;branch=main \
           file://aesdsocket-start.sh"

# ⚠️ IMPORTANT:
# Replace this with the commit hash where Assignment 6 Part 1 PASSED
SRCREV = "e85eabb63d43ce3adf2c2fb96a078798d7ced113"

# Build from the server directory inside the repo
S = "${WORKDIR}/git/server"

# ================================
# Build settings
# ================================
inherit cmake

# ================================
# Install steps
# ================================
do_install() {
    # Install aesdsocket binary
    install -d ${D}${bindir}
    install -m 0755 aesdsocket ${D}${bindir}

    # Install init script to auto-start aesdsocket
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/aesdsocket-start.sh ${D}${sysconfdir}/init.d/aesdsocket
}

# ================================
# Files packaged
# ================================
FILES:${PN} += "${bindir}/aesdsocket \
                ${sysconfdir}/init.d/aesdsocket"

