echo "OpenCV installation by learnOpenCV.com"
 
echo "Installing OpenCV - 4.0"
  
#Specify OpenCV version
cvVersion="master"

# Clean build directories
rm -rf opencv
rm -rf opencv_contrib
mkdir installation
mkdir installation/OpenCV-"$cvVersion"

# Save current working directory
cwd=$(pwd)

sudo yum -y install epel-release
sudo yum -y install git gcc gcc-c++ cmake3
sudo yum -y install qt5-qtbase-devel
sudo yum install -y python34 python34-devel python34-pip
sudo yum install -y python python-devel python-pip
 
sudo yum -y install python-devel numpy python34-numpy
sudo yum -y install gtk2-devel
 
sudo yum install -y libpng-devel
sudo yum install -y jasper-devel
sudo yum install -y openexr-devel
sudo yum install -y libwebp-devel
sudo yum -y install libjpeg-turbo-devel 
sudo yum install -y freeglut-devel mesa-libGL mesa-libGL-devel
sudo yum -y install libtiff-devel 
sudo yum -y install libdc1394-devel
sudo yum -y install tbb-devel eigen3-devel
sudo yum -y install boost boost-thread boost-devel
sudo yum -y install libv4l-devel
sudo yum -y install gstreamer-plugins-base-devel

sudo pip3 install virtualenv virtualenvwrapper
echo "export WORKON_HOME=$HOME/.virtualenvs" >> ~/.bashrc
echo "export VIRTUALENVWRAPPER_PYTHON=/usr/bin/python3" >> ~/.bashrc
echo "source /usr/bin/virtualenvwrapper.sh" >> ~/.bashrc
export VIRTUALENVWRAPPER_PYTHON=/usr/bin/python3
source /usr/bin/virtualenvwrapper.sh

git clone https://github.com/opencv/opencv.git
cd opencv
git checkout $cvVersion
cd ..
 
git clone https://github.com/opencv/opencv_contrib.git
cd opencv_contrib
git checkout $cvVersion
cd ..

cd opencv
mkdir build
cd build
