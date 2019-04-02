#!/bin/sh

mkdir $1
cd $1
mkdir dev output
touch webpack.config.js index.html
npm init
npm install —save react react-dom
npm install create-react-class --save
npm install --save webpack
npm install --save babel-loader babel-core babel-preset-es2015 babel-preset-react
