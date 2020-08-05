#ifndef HELLOWORLD_BASE_IMPL_BASE_H
#define HELLOWORLD_BASE_IMPL_BASE_H

#include <boost/thread.hpp>
#include <ossie/Component.h>
#include <ossie/ThreadedComponent.h>


class HelloWorld_base : public Component, protected ThreadedComponent
{
    public:
        HelloWorld_base(const char *uuid, const char *label);
        ~HelloWorld_base();

        void start() throw (CF::Resource::StartError, CORBA::SystemException);

        void stop() throw (CF::Resource::StopError, CORBA::SystemException);

        void releaseObject() throw (CF::LifeCycle::ReleaseError, CORBA::SystemException);

        void loadProperties();

    protected:

    private:
};
#endif // HELLOWORLD_BASE_IMPL_BASE_H
