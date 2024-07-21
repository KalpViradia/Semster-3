function moduleExport(string) {
    console.log(string);
}
module.exports.moduleExport = moduleExport;

const path = require('path');
console.log(path.normalize('/foo/abc/..'));
console.log(path.join('/foo','bar','abc'));
console.log(path.resolve('abc','xyz'));
console.log(path.relative('/foo/bar','/foo/abc'));
console.log(path.dirname('/foo/abc.txt'));
console.log(path.basename('/foo/abc.txt'));
console.log(path.extname('/foo/abc.txt'));
console.log(path.isAbsolute('/foo/bar'));
console.log(path.parse('/home/user/dir/file.txt'));
console.log('foo/bar/baz'.split(path.sep));