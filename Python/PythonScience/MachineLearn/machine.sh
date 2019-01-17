#!/bin/sh

echo "Install Support Libs"
sudo apt-get install libblas-dev -y       ## 1-2 minutes
sudo apt-get install liblapack-dev -y      ## 1-2 minutes
sudo apt-get install gfortran -y          ## 2-3 minutes
sudo apt-get install python-setuptools -y  ## ?

echo "Install SCIPY"
sudo easy_install scipy -y                ## 2-3 hours

echo "Install MatPlotLib"
sudo pip install matplotlib

echo "Install Pandas"
sudo pip install pandas

echo "Install SciKit"
sudo pip install scikit-learn
