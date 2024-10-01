import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function Students(){

    const [data, setData] = useState([]);

    const apiUrl = "https://66ed2084380821644cdb7fe9.mockapi.io/Students";

    useEffect(()=>{
        fetch(apiUrl, {method:"GET"})
        .then(res=>res.json())
        .then(res=>setData(res));
    },[]);

    const foramtedStudents = data.map((stu)=>{
        return(
            <tr>
                <td>{stu.ID}</td>
                <td>{stu.RoolNo}</td>
                <td>{stu.Name}</td>
                <td><Link className="btn btn-primary" to={"/students/"+stu.ID}>Read More</Link></td>
            </tr>
        );
    })

    return(<table className="table">{foramtedStudents}</table>);
}

export default Students;