const express = require('express');
const fs = require('fs');
const app = express();

app.use(logger);
app.use(authorizer);

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

function logger(req,res,next) {
    fs.appendFileSync('Logger.txt',`The user send a request at ${Date.now()} from ${req.method}\n`);
    next(); 
}

function authorizer(req,res,next) {
    if(req.query.admin === 'true') {
        next();
        return;
    }
    res.send('Not Authorized');
}

app.listen(3003,()=>{
    console.log('Server Running At Port 3003');
});