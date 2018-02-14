#!/bin/sh

cd /backup
today=`date +"%m-%d-%y"`

echo "Removing any old zips..."
rm -R *.zip
echo "Backing up network interfaces..."
tar cf network.tar /etc/network/interfaces
echo "Backing up apps directory..."
tar cf apps.tar /apps/*
echo "Backing up cloud directory..."
tar cf cloud.tar /cloud/*
echo "Backing up home directory..."
tar cf home.tar ~/*
echo "Backing up www directory..."
tar cf web.tar /var/www/html/*

echo "Creating backup.zip file..."
zip -r masterBackup$today.zip apps.tar cloud.tar home.tar network.tar web.tar 
rm -R *.tar 
echo "Done!"
 
