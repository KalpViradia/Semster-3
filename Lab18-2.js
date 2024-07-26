const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res)=>{
    if(req.url === '/home') {
        fs.readFile('Lab18-2HomePage.html',(err,data) => {
            res.end(data);
        });
    }
    else if(req.url === '/about') {
        fs.readFile('Lab18-2AboutPage.html',(err,data) => {
            res.end(data);
        });
    }
    else if(req.url === '/services') {
        fs.readFile('Lab18-2ServicesPage.html',(err,data) => {
            res.end(data);
        });
    }
    else if(req.url === '/contact') {
        fs.readFile('Lab18-2ContactPage.html',(err,data) => {
            res.end(data);
        });
    }
    else if(req.url === '/blog') {
        fs.readFile('Lab18-2BlogPage.html',(err,data) => {
            res.end(data);
        });
    }
    else {
        fs.readFile('Lab18-2FrontPage.html',(err,data) => {
            res.end(data);
        });
    }
});
server.listen(4500,()=>{
    console.log('Server is running on port 4500');
});