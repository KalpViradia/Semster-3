import { useState } from "react";
import { useNavigate } from "react-router-dom";

function AddStudents(){
    const [data, setData] = useState({});
    const navigate = useNavigate();
    return(
        <>
            <div class="form-group row">
                <label for="text2" class="col-4 col-form-label">StudentID</label> 
                <div class="col-8">
                <input onChange={(e)=>{
                    setData({...data,ID:e.target.value})
                }} type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group row">
                <label for="text1" class="col-4 col-form-label">Student Name</label> 
                <div class="col-8">
                <input onChange={(e)=>{
                    setData({...data,Name:e.target.value})
                }}  type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group row">
                <label for="text4" class="col-4 col-form-label">Image Path</label> 
                <div class="col-8">
                <input onChange={(e)=>{
                    setData({...data,ProfilePic:e.target.value})
                }}  type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group row">
                <label for="text3" class="col-4 col-form-label">Roll Number</label> 
                <div class="col-8">
                <input onChange={(e)=>{
                    setData({...data,RollNo:e.target.value})
                }}  type="text" class="form-control" />
                </div>
            </div> 
            <div class="form-group row">
                <div class="offset-4 col-8">
                <button onClick={()=>{
                    const apiUrl = "https://66ed2084380821644cdb7fe9.mockapi.io/Students";

                    fetch(apiUrl,{
                        method:"POST",
                        body:JSON.stringify(data),
                        headers:{
                            "Content-Type":"application/json"
                        }
                    })
                    .then(res=>res.json())
                    .then(res=>{
                        navigate('/Students');
                    });
                }} name="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </>
    );
}

export default AddStudents;