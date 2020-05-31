INCLUDE(FindPkgConfig)
PKG_CHECK_MODULES(PC_MY_MODULE my_module)

FIND_PATH(
    MY_MODULE_INCLUDE_DIRS
    NAMES my_module/api.h
    HINTS $ENV{MY_MODULE_DIR}/include
        ${PC_MY_MODULE_INCLUDEDIR}
    PATHS ${CMAKE_INSTALL_PREFIX}/include
          /usr/local/include
          /usr/include
)

FIND_LIBRARY(
    MY_MODULE_LIBRARIES
    NAMES gnuradio-my_module
    HINTS $ENV{MY_MODULE_DIR}/lib
        ${PC_MY_MODULE_LIBDIR}
    PATHS ${CMAKE_INSTALL_PREFIX}/lib
          ${CMAKE_INSTALL_PREFIX}/lib64
          /usr/local/lib
          /usr/local/lib64
          /usr/lib
          /usr/lib64
)

INCLUDE(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(MY_MODULE DEFAULT_MSG MY_MODULE_LIBRARIES MY_MODULE_INCLUDE_DIRS)
MARK_AS_ADVANCED(MY_MODULE_LIBRARIES MY_MODULE_INCLUDE_DIRS)

