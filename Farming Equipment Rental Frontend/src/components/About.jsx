function About() {
    return (
        <>
            {/* <div className="page-heading about-heading header-text" style={{ backgroundImage: 'url(images/heading-1-1920x500.jpg)' }}>
             */}
             <div className="page-heading about-heading header-text">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <div className="text-content">
                                <h4>About us</h4>
                                <h2>Equipment rental</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="best-features about-features">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <div className="section-heading">
                                <h2>We are providing Farming Equipment on rents</h2>
                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="right-image">
                                {/* images/about-1-570x350.jpg */}
                                <img src="images/Aboutus_image.jpg" alt />
                                {/* images\Aboutus_image.jpg */}
                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="left-content">
                                <h4>Farming Service Provider</h4>
                                <p><strong >FSP</strong> is worlds first online marketplace providing well-structured bidding platforms for buying and selling of Tractors and Implements in Agricultural Mechanization. We provide the one-stop solution for buyers, sellers and manufacturers to connect with each other and fulfill their requirements. We have abundant wealth of Agriculture knowledge and huge experience in both Agro-mechanism and retail sectors.
                                  FSP has a completely innovative, challenge accepting and proven team with combined experience in technology, marketing and E-commerce provides a truly 21st century experience technology-driven market approach that enable your exchange of knowledge and information between two users by carrying transparency, building trust with correct information and services.</p>
                                <ul className="social-icons">
                                    <li><a href="#"><i className="fa fa-facebook-square" /></a></li>
                                    <li><a href="#"><i className="fa fa-twitter-squarer" /></a></li>
                                    <li><a href="#"><i className="fab fa-linkedin"/></a></li>
                                    {/* <li><a href="#"><i className="fa fa-behance" /></a></li> */}
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </>
    )
}

export default About;