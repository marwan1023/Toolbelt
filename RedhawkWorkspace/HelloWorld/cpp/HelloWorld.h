#ifndef HELLOWORLD_I_IMPL_H
#define HELLOWORLD_I_IMPL_H

#include "HelloWorld_base.h"

class HelloWorld_i : public HelloWorld_base
{
    ENABLE_LOGGING
    public:
        HelloWorld_i(const char *uuid, const char *label);
        ~HelloWorld_i();

        void constructor();

        int serviceFunction();
};

#endif // HELLOWORLD_I_IMPL_H
