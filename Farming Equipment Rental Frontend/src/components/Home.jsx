const Home=()=>{
    return(
        <>
        <div>
        <div id="carouselExampleCaptions" className="carousel slide" data-ride="carousel">
            <ol className="carousel-indicators">
              <li data-target="#carouselExampleCaptions" data-slide-to={0} className="active" />
              <li data-target="#carouselExampleCaptions" data-slide-to={1} />
              <li data-target="#carouselExampleCaptions" data-slide-to={2} />
            </ol>
          <div className="carousel-inner">
            <div className="carousel-item active">
              <img style={{height:"700px"}} src='../../images/frontimg1.jpg' className="d-block w-100" alt="Slides" />
              <div className="carousel-caption d-none d-md-block">
                <h5>Find your equipment today!</h5>
                <h4>Book the best equipment for you</h4>
              </div>
            </div>
            <div className="carousel-item">
              <img style={{height:"700px"}} src='../../images/frontimg2.jpg' className="d-block w-100" alt="Slides" />
              <div className="carousel-caption d-none d-md-block">
                <h5>Find the best variant</h5>
                <h4>A lot of variants available</h4>
              </div>
            </div>
            <div className="carousel-item">
              <img style={{height:"700px"}} src='../../images/frontimg3.jpg' className="d-block w-100" alt="Slides" />
              <div className="carousel-caption d-none d-md-block">
                <h5>Best Services</h5>
                <h4>Full Functional Feedback System</h4>
              </div>
            </div>
        </div>
        <button className="carousel-control-prev bg-transparent border-0" type="button" data-target="#carouselExampleCaptions" data-slide="prev">
          <span className="carousel-control-prev-icon" aria-hidden="true" />
          <span className="sr-only">Previous</span>
        </button>
        <button className="carousel-control-next bg-transparent border-0" type="button" data-target="#carouselExampleCaptions" data-slide="next">
          <span className="carousel-control-next-icon" aria-hidden="true" />
          <span className="sr-only">Next</span>
        </button>
      </div>


  
</div>

        </>
    )
}

export default Home;