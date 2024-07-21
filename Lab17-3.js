const fs = require('fs');

fs.exists('JS.text', (exists)=>{
    console.log(exists ? 'Found' : 'Not Found!');
});

fs.stat('Lab17-1.js', (err,data)=>{
    console.log(data);
});

fs.unlink('JS1.txt', (err)=>{
    if(err){throw err}
    console.log('File Deleted');
});

fs.rename('JS1.txt','JS2.txt', (err)=>{
    if(err){throw err}
    console.log('File Renamed');
});

fs.readFile('JS.txt', (err,data)=>{
    console.log(data.toString());
});

fs.writeFile('JS.txt', 'File writing form fs.writefile', (err)=>{
    if (err) {
      console.error(err);
    } else {
        console.log('File written successfully');
    }
});

fs.appendFile('JS.txt', 'File writing from fs.appendfile', (err)=>{
    if (err) {
      console.error(err);
    } else {
      console.log('File appened successfully');
    }
});