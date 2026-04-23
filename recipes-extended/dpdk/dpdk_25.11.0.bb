include dpdk.inc

SRC_URI = "git://dpdk.org/git/dpdk${STABLE};protocol=https;branch=${BRANCH};tag=v25.11"
SRC_URI += " file://0001-config-meson-get-cpu_instruction_set-from-meson-opti.patch"

STABLE = "-stable"
BRANCH = "25.11"
SRCREV = "ed957165eadbe60a47d5ec223578cdd1c13d0bd9"

PACKAGES =+ "${PN}-examples ${PN}-tools"

FILES:${PN} += " ${bindir}/dpdk-testpmd \
		 ${bindir}/dpdk-proc-info \
		 ${libdir}/*.so* \
		 ${libdir}/dpdk/pmds-26.0/*.so* \
		 "
FILES:${PN}-examples = " \
	${prefix}/share/dpdk/examples/* \
	"

FILES:${PN}-tools = " \
    ${bindir}/dpdk-pdump \
    ${bindir}/dpdk-test \
    ${bindir}/dpdk-test-* \
    ${bindir}/dpdk-*.py \
    "

INSANE_SKIP:${PN} = "dev-so"
