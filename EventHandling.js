function Football() {
    const goal = () => {
      alert("Goal!");
    }
  
    return (
      <button onClick={goal}>Score</button>
    );
}

export default Football;