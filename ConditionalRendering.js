function Welcome(props) {
    const isComputer = props.isComputer;
    return(
        <>
            {isComputer && <h1>Computer Department</h1>}
            {!isComputer && <h1>Other Department</h1>}
        </>
    );
}

export default Welcome;