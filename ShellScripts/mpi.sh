#!/bin/sh

mkdir mpich3

cd mpich3

mkdir build install

wget http://www.mpich.org/static/downloads/3.1.3/mpich-3.1.3.tar.gz

tar xvfz mpich-3.1.3.tar.gz

cd build

/home/hadoop/mpich3/mpich-3.1.3/configure --enable-fortran=no -prefix=/home/hadoop/mpich3/install

make 

make install
 
