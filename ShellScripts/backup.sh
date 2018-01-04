#!/bin/sh

cd /backup
today=`date +"%m-%d-%y"`

echo "Removing any old zips..."
rm -R *.zip
echo "Backing up apps directory..."
tar cvf apps.tar /apps/*
echo "Backing up cloud directory..."
tar cvf cloud.tar /cloud/*
echo "Backing up home directory..."
tar cvf home.tar ~/*


echo "Creating backup.zip file..."
zip -r masterBackup$today.zip apps.tar cloud.tar home.tar 
rm -R *.tar 
echo "Done!"
 
