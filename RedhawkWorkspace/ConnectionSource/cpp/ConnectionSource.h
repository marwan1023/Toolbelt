#ifndef CONNECTIONSOURCE_I_IMPL_H
#define CONNECTIONSOURCE_I_IMPL_H

#include "ConnectionSource_base.h"

class ConnectionSource_i : public ConnectionSource_base
{
    ENABLE_LOGGING
    public:
        ConnectionSource_i(const char *uuid, const char *label);
        ~ConnectionSource_i();

        void constructor();

        int serviceFunction();
        std::vector<short> data;
        bulkio::OutShortStream stream;
};

#endif // CONNECTIONSOURCE_I_IMPL_H
