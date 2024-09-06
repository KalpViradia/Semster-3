const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const Students = require('./Lab21-4');

mongoose.connect('mongodb+srv://Main:Main@cluster0.oxhzd.mongodb.net/test').then(()=>{
    console.log('Database Connected');

    const app = express();
    app.use(bodyParser.urlencoded());

    app.get('/students',async (req,res)=>{
        const ans = await Students.find();
        res.send(ans);
    });
    
    app.get('/students/:id',async (req,res)=>{
        const ans = await Students.findOne({name:req.params.id});
        res.send(ans);
    });
    
    app.post('/students',async (req,res)=>{
        stu = new Students({... req.body});
        const ans = await stu.save();
        res.send(ans);
    });
    
    app.delete('/students/id',async (req,res)=>{
        const ans = await Students.deleteOne({name:req.params.id});
        res.send(ans);
    });
    
    app.patch('/students/id',async (req,res)=>{
        const stu = await Students.findOne({name:req.params.id});
        stu.name = req.boby.name;
        const ans = await stu.save();
        res.send(ans);
    });
    
    app.listen(3007,()=>{
        console.log('server is running on port 3007');
    });
});