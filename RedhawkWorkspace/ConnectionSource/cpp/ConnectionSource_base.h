#ifndef CONNECTIONSOURCE_BASE_IMPL_BASE_H
#define CONNECTIONSOURCE_BASE_IMPL_BASE_H

#include <boost/thread.hpp>
#include <ossie/Component.h>
#include <ossie/ThreadedComponent.h>

#include <bulkio/bulkio.h>

class ConnectionSource_base : public Component, protected ThreadedComponent
{
    public:
        ConnectionSource_base(const char *uuid, const char *label);
        ~ConnectionSource_base();

        void start() throw (CF::Resource::StartError, CORBA::SystemException);

        void stop() throw (CF::Resource::StopError, CORBA::SystemException);

        void releaseObject() throw (CF::LifeCycle::ReleaseError, CORBA::SystemException);

        void loadProperties();

    protected:
        // Member variables exposed as properties
        /// Property: xfer_length
        CORBA::ULong xfer_length;

        // Ports
        /// Port: output
        bulkio::InShortPort *output;

    private:
};
#endif // CONNECTIONSOURCE_BASE_IMPL_BASE_H
