SUMMARY = "AESD Socket Application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/siddjove/assignments-3-and-later-siddjove2.git;protocol=ssh;branch=main \
           file://aesdsocket-start.sh"

SRCREV = "ef54bb34ec2d4f6634475f0a88d2161cd5851e33"

# Build from server/ in that repo
S = "${WORKDIR}/git/server"

# Link flags (use only if needed)
TARGET_LDFLAGS += "-pthread"

# Runtime deps (if any extra libs required, add them here)
RDEPENDS_${PN} += "libgcc pthread"

# Initscript registration (update-rc.d)
INITSCRIPT_NAME = "aesdsocket"
INITSCRIPT_PARAMS = "defaults"

FILES_${PN} += "${bindir}/aesdsocket ${sysconfdir}/init.d/aesdsocket"

do_configure () {
    :
}

do_compile () {
    oe_runmake
}

do_install () {
    # Install binary
    install -d ${D}${bindir}
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/aesdsocket

    # Install init script
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/aesdsocket-start.sh ${D}${sysconfdir}/init.d/aesdsocket
}
