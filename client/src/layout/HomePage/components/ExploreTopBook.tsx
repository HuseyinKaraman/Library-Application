export const ExploreTopBook = () => {
    return (
        <div className="p-5 mb-4 bg-dark header">
            <div className="container-fluid py-5 text-white d-flex justify-content-center align-items-center ">
                <div>
                    <h1 className="display-5 fw-bold">Find your next adventure</h1>
                    <p className="col-md-8 fs-4">Explore a variety of books and find your next adventure.</p>
                    <a type="button" href="/books" className="btn main-color btn-lg text-white">
                        Explore Top Books
                    </a>
                </div>
            </div>
        </div>
    );
};
