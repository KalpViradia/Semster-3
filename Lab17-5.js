const http = require('http');

http.createServer((req, res)=>{
    res.end('Hello World');
}).listen(3000,()=>{
    console.log('Server is running on port 3000');
});