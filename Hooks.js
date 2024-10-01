import { useEffect, useState } from "react";

function Hooks() {
    const [count, setCount] = useState(0);

    useEffect(() => {
        alert(`Value of count is ${count}`);
    }, [count]);
    
    return (
        <>
            <h1>Value of count is {count}</h1>
            <button onClick={() => setCount(count + 1)}>Increment</button>
        </>
    )
}

export default Hooks;