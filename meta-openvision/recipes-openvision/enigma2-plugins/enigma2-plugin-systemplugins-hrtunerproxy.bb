SUMMARY = "Setup Enigma2 to act as HR-Tuner Proxy"
DESCRIPTION = "Setup Enigma2 to act as HR-Tuner Proxy"
MAINTAINER = "OpenViX"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/OpenViX/HRTunerProxy.git;protocol=git"

S = "${WORKDIR}/git"

RCONFLICTS_${PN} = "enigma2-plugin-systemplugins-plexdvrapi"
RREPLACES_${PN} = "enigma2-plugin-systemplugins-plexdvrapi"

RDEPENDS_${PN} = " \
    python-argparse \
    "

do_install_prepend() {
    echo ${GITPKGVTAG} | awk -F"-" '{print $1}'> ${S}/build/lib/SystemPlugins/HRTunerProxy/PLUGIN_VERSION
}
