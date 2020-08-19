#include <iostream>
#include "ossie/ossieSupport.h"

#include "ConnectionSource.h"
extern "C" {
    Resource_impl* make_component(const std::string& uuid, const std::string& identifier)
    {
        return new ConnectionSource_i(uuid.c_str(), identifier.c_str());
    }
}

