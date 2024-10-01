import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

function StudentsDetails(){
    const [data, setData] = useState({});

    const { id } = useParams();

    const navigate = useNavigate();

    const apiUrl = "https://66ed2084380821644cdb7fe9.mockapi.io/Students/"+id;

    useEffect(()=>{
        fetch(apiUrl, {method:"GET"})
        .then(res=>res.json())
        .then(res=>setData(res));
    },[]);

    return(
        <>
            <Link to="/students" className="btn btn-info">Back</Link>
            <button
                className="btn btn-warning" 
                onClick={() => {
                navigate("/students/" + id + "/edit");
            }}>Edit</button>

            <button className="btn btn-danger" onClick={()=>{
                const apiUrl = "https://66ed2084380821644cdb7fe9.mockapi.io/Students/"+id;

                fetch(apiUrl, {method:"DELETE"})
                .then(res=>res.json())
                .then(res=>{
                    navigate('/students');
                })

                

            }}>Delete</button>
            <h1>{data.Name}</h1>
            <img src={data.ProfilePic} />
            <h3>{data.RollNo}</h3>
        </>
    );
}

export default StudentsDetails;