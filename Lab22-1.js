const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const Faculties = require('./Lab21-3');

mongoose.connect('mongodb+srv://Main:Main@cluster0.oxhzd.mongodb.net/test').then(()=>{
    console.log('Database Connected');

    const app = express();
    app.use(bodyParser.urlencoded());

    app.get('/faculties',async (req,res)=>{
        const ans = await Faculties.find();
        res.send(ans);
    });
    
    app.get('/faculties/:id',async (req,res)=>{
        const ans = await Faculties.findOne({name:req.params.id});
        res.send(ans);
    });
    
    app.post('/faculties',async (req,res)=>{
        fac = new Faculties({... req.body});
        const ans = await fac.save();
        res.send(ans);
    });
    
    app.delete('/faculties/id',async (req,res)=>{
        const ans = await Faculties.deleteOne({name:req.params.id});
        res.send(ans);
    });
    
    app.patch('/faculties/id',async (req,res)=>{
        const fac = await Faculties.findOne({name:req.params.id});
        fac.name = req.boby.name;
        const ans = await fac.save();
        res.send(ans);
    });
    
    app.listen(3006,()=>{
        console.log('server is running on port 3006');
    });
});