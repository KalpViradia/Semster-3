import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

function EditStudents() {
    const [data, setData] = useState({});
    const navigate = useNavigate();
    const id = useParams();

    useEffect(() => {
        const apiUrl = 'https://66ed2084380821644cdb7fe9.mockapi.io/Students/'+id;
        fetch(apiUrl)
            .then(res => res.json())
            .then(studentData => {
                setData(studentData);
            });
    }, [id]);

    return (
        <>
            <div className="form-group row">
                <label htmlFor="ID" className="col-4 col-form-label">StudentID</label>
                <div className="col-8">
                    <input
                        name="ID"
                        value={data.ID}
                        onChange={(e) => {
                            setData(prevData => ({
                                ...prevData,
                                [e.target.name]: e.target.value
                            }))
                        }}
                        type="text"
                        className="form-control"
                    />
                </div>
            </div>
            <div className="form-group row">
                <label htmlFor="Name" className="col-4 col-form-label">Student Name</label>
                <div className="col-8">
                    <input
                        name="Name"
                        value={data.Name}
                        onChange={(e) => {
                            setData(prevData => ({
                                ...prevData,
                                [e.target.name]: e.target.value
                            }))
                        }}
                        type="text"
                        className="form-control"
                    />
                </div>
            </div>
            <div className="form-group row">
                <label htmlFor="ProfilePic" className="col-4 col-form-label">Image Path</label>
                <div className="col-8">
                    <input
                        name="ProfilePic"
                        value={data.ProfilePic}
                        onChange={(e) => {
                            setData(prevData => ({
                                ...prevData,
                                [e.target.name]: e.target.value
                            }))
                        }}
                        type="text"
                        className="form-control"
                    />
                </div>
            </div>
            <div className="form-group row">
                <label htmlFor="RollNo" className="col-4 col-form-label">Roll Number</label>
                <div className="col-8">
                    <input
                        name="RollNo"
                        value={data.RollNo}
                        onChange={(e) => {
                            setData(prevData => ({
                                ...prevData,
                                [e.target.name]: e.target.value
                            }))
                        }}
                        type="text"
                        className="form-control"
                    />
                </div>
            </div>
            <div className="form-group row">
                <div className="offset-4 col-8">
                    <button onClick={() => {
                        const apiUrl = `https://66ed2084380821644cdb7fe9.mockapi.io/Students/`      +id;

                        fetch(apiUrl, {
                            method: "PUT",
                            body: JSON.stringify(data),
                            headers: {
                                "Content-Type": "application/json"
                            }
                        })
                        .then(res => res.json())
                        .then(() => {
                            navigate('/Students');
                        });
                    }} className="btn btn-primary">Update</button>
                </div>
            </div>
        </>
    );
}

export default EditStudents;