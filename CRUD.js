const express = require('express');
const bodyParser = require('body-parser');
const app = express();
app.use(bodyParser.urlencoded({extended:false}));

students = [
    {
        Id : 10,
        Name : 'abc',
        Age : 20  
    },
    {
        Id : 20,
        Name : 'def',
        Age : 25  
    },
    {
        Id : 30,
        Name : 'ghi',
        Age : 26  
    },
    {
        Id : 40,
        Name : 'jkl',
        Age : 19 
    },
    {
        Id : 50,
        Name : 'mno',
        Age : 18  
    }
];

app.get('/students',(req,res)=>{
    res.send(students);
});

app.get('/students/:id',(req,res)=>{
    const result = students.find(stu=>stu.Id==req.params.id);
    res.send(result);
});

app.post('/students',(req,res)=>{
    students.push(req.body);
    res.send('Object added');
});

app.delete('/students/id',(req,res)=>{
    const idToDelete = students.findIndex(stu=>stu.Id==req.params.id);
    students.splice(idToDelete,1);
    res.send('Object deleted');
});

app.patch('/students/id',(req,res)=>{
    const idToUpdate = students.findIndex(stu=>stu.Id==req.params.id);
    students[idToUpdate]={...students[idToUpdate], ...req.body};
    res.send('Object updated');
});

app.listen(3007,()=>{
    console.log('server is running on port 3007');
});