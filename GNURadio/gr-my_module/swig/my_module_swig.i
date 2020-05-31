/* -*- c++ -*- */

#define MY_MODULE_API

%include "gnuradio.i"			// the common stuff

//load generated python docstrings
%include "my_module_swig_doc.i"

%{
#include "my_module/cognitive.h"
%}


%include "my_module/cognitive.h"
GR_SWIG_BLOCK_MAGIC2(my_module, cognitive);
