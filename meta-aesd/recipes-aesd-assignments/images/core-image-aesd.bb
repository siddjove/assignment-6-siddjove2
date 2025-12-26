inherit core-image

# Install required packages
CORE_IMAGE_EXTRA_INSTALL += " \
    aesd-assignments \
    openssh \
    busybox \
"

inherit extrausers

# ============================
# Root login setup (for testing)
# ============================
# Default root password: root
PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"

