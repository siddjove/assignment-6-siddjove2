inherit core-image

CORE_IMAGE_EXTRA_INSTALL += " \
    aesd-assignments \
    openssh \
"

inherit extrausers

# Default root password (for coursework only – NOT production safe)
PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"

