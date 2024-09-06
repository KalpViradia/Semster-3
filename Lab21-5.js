const express = require('express');
const mongoose = require('mongoose');
const app = express();
const userSchema = mongoose.Schema({
    name: String,
    brand: String,
    price: Number
});
const userModel = mongoose.model('Products', userSchema);

module.exports= userModel;
