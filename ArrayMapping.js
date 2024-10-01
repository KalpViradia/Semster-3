function Faculites() {
    const Faculites = [
        {
            Name:'Abc',
            Experience:15
        },

        {
            Name:'Def',
            Experience:12
        },

        {
            Name:'Ghi',
            Experience:17
        },
    ];
    const FaculitesList = Faculites.map((element) => {
        return(
            <table>
                <tr>
                    <th>Name</th>
                    <th>Experience</th>
                </tr>
                <tr>
                    <td>{element.Name}</td>
                    <td>{element.Experience}</td>
                </tr>        
            </table>
        );
    });
    return(FaculitesList);
}

function Students() {
    const Students = [
        {
            Name:'Pqr',
            Semester:3
        },

        {
            Name:'Abc',
            Semester:6
        },

        {
            Name:'Tuv',
            Semester:4
        },
    ];
    const StudentsList = Students.map((element) => {
        return(
            <table>
                <tr>
                    <th>Name</th>
                    <th>Semester</th>
                </tr>
                <tr>
                    <td>{element.Name}</td>
                    <td>{element.Semester}</td>
                </tr>        
            </table>
        );
    });
    return(StudentsList);
}

function Products() {
    const Products = [
        {
            Name:'S24 Ultra',
            Type:'Moblie'
        },

        {
            Name:'Tab S9',
            Type:'Tablet'
        },

        {
            Name:'G15',
            Type:'Laptop'
        },
    ];
    const ProductsList = Products.map((element) => {
        return(
            <table>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                </tr>
                <tr>
                    <td>{element.Name}</td>
                    <td>{element.Type}</td>
                </tr>        
            </table>
        );
    });
    return(ProductsList);
}

export {Faculites, Students, Products};