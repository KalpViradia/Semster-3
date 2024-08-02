const express = require('express');
const app = express();
app.get('/',(req,res)=>{
    res.sendFile('D:/College/Semster 3/Web Technology/Programs/ExpressJS/Programs/Lab19-3FrontPage.html',(err,data)=>{
        if(err) console.log(err);
    });
});

app.get('/home',(req,res)=>{
    res.sendFile('D:/College/Semster 3/Web Technology/Programs/ExpressJS/Programs/Lab19-3HomePage.html',(err,data)=>{
        if(err) console.log(err);
    });
});

app.get('/about',(req,res)=>{
    res.sendFile('D:/College/Semster 3/Web Technology/Programs/ExpressJS/Programs/Lab19-3AboutPage.html',(err,data)=>{
        if(err) console.log(err);
    });
});

app.get('/services',(req,res)=>{
    res.sendFile('D:/College/Semster 3/Web Technology/Programs/ExpressJS/Programs/Lab19-3ServicesPage.html',(err,data)=>{
        if(err) console.log(err);
    });
});

app.get('/contact',(req,res)=>{
    res.sendFile('D:/College/Semster 3/Web Technology/Programs/ExpressJS/Programs/Lab19-3ContactPage.html',(err,data)=>{
        if(err) console.log(err);
    });
});

app.get('/blog',(req,res)=>{
    res.sendFile('D:/College/Semster 3/Web Technology/Programs/ExpressJS/Programs/Lab19-3BlogPage.html',(err,data)=>{
        if(err) console.log(err);
    });
});

app.listen(3002,()=>{
    console.log('Server Running At Port 3002');
});