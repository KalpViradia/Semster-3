const express = require('express');
const fs = require('fs');
const app = express();

app.use(express.static('Static'));

app.get('/',(req,res)=>{
    res.send('Hello World');
});

app.get('/home',(req,res)=>{
    res.send('Home Page');
});

app.get('/about',(req,res)=>{
    res.send('About Page');
});

app.get('/contact',(req,res)=>{
    res.send('Contact Page');
});

app.get('/help',(req,res)=>{
    res.send('Help Page');
});

app.get('/services',(req,res)=>{
    res.send('Services Page');
});

app.listen(3004,()=>{
    console.log('Server Running At Port 3004');
});