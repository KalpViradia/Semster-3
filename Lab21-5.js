const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const Products = require('./Lab21-5Schema');

mongoose.connect('mongodb+srv://Main:Main@cluster0.oxhzd.mongodb.net/test').then(()=>{
    console.log('Database Connected');

    const app = express();
    app.use(bodyParser.urlencoded());

    app.get('/products',async (req,res)=>{
        const ans = await Products.find();
        res.send(ans);
    });
    
    app.get('/products/:id',async (req,res)=>{
        const ans = await Products.findOne({name:req.params.id});
        res.send(ans);
    });
    
    app.post('/products',async (req,res)=>{
        pro = new Products({... req.body});
        const ans = await pro.save();
        res.send(ans);
    });
    
    app.delete('/products/id',async (req,res)=>{
        const ans = await Products.deleteOne({name:req.params.id});
        res.send(ans);
    });
    
    app.patch('/products/id',async (req,res)=>{
        const pro = await Products.findOne({name:req.params.id});
        pro.name = req.boby.name;
        const ans = await pro.save();
        res.send(ans);
    });
    
    app.listen(3008,()=>{
        console.log('server is running on port 3008');
    });
});