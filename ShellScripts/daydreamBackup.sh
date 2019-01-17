#!/bin/sh

cd /home/hadoop/FreeAgent/FTG
today=`date +"%m-%d-%y"`
zipcount=`ls -l *.zip | wc -l`
archiveLimit=5

if [ "$zipcount" -eq "$archiveLimit" ]; then 
  echo "Removing old files..."
  oldestFile=`ls -gt|tail -1`
  rm -R /home/hadoop/FreeAgent/FTG/$oldestFile 
fi 


echo "Copying new files..."
cp -R /home/hadoop/Dropbox/*Daydreams* /home/hadoop/FreeAgent/FTG
cp -R /home/hadoop/Dropbox/*DayDreams* /home/hadoop/FreeAgent/FTG
mkdir dInteractive
mv *Daydreams* dInteractive
mv *DayDreams* dInteractive
zip -r daydreams$today.zip dInteractive
rm -R dInteractive
echo "Done!"
 
