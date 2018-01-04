#!/bin/sh

cd ~/linux


#RPI kernel
#RPI 2 kernel7

KERNEL=kernel7

#Raspi 2 - make bcm2709_defconfig
#Raspi 1 make bcmrpi_defconfig 

make zImage modules dtbs
sudo make modules_install
sudo cp arch/arm/boot/dts/*.dtb /boot/
sudo cp arch/arm/boot/dts/overlays/*.dtb* /boot/overlays/
sudo cp arch/arm/boot/dts/overlays/README /boot/overlays/
sudo scripts/mkknlimg arch/arm/boot/zImage /boot/$KERNEL.img
