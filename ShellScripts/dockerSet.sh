#!/bin/sh

service docker stop
service docker restart
chown darthbison /var/run/docker.sock
