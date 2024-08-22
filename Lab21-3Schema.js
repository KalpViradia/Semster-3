const express = require('express');
const mongoose = require('mongoose');
const app = express();
const userSchema = mongoose.Schema({
    name: String,
    experience: String,
    department: String
});
const userModel = mongoose.model('Faculties', userSchema);

module.exports= userModel;