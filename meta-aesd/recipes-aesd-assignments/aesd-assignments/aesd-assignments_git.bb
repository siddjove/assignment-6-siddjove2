SUMMARY = "AESD Socket Application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/siddjove/assignments-3-and-later-siddjove2.git;protocol=ssh;branch=main \
           file://aesdsocket-start.sh"

SRCREV = "31c244cddaf520b95124a49fb86975aaf11ec952"

S = "${WORKDIR}/git/server"

TARGET_LDFLAGS += "-pthread"

inherit update-rc.d

INITSCRIPT_NAME = "aesdsocket"
INITSCRIPT_PARAMS = "defaults"

FILES:${PN} += "${bindir}/aesdsocket ${sysconfdir}/init.d/aesdsocket"

do_configure () {
    :
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/aesdsocket

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/aesdsocket-start.sh ${D}${sysconfdir}/init.d/aesdsocket
}

