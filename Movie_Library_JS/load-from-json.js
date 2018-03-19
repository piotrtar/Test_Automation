'use strict';

const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({input: process.stdin, output: process.stdout});

const loadFileAndParseToJsonObj = () => {
    let parsedData;
    try {
        const data = fs.readFileSync(process.argv[2], 'utf8');
        parsedData = JSON.parse(data);
    } catch(e) {
        console.log('Error:', e.stack);
    }
    return parsedData;
}

const menu = "\nPlease Choose an option. Type a number and pass a string in <>\n"
            + "1 <actor name>               Filter movies by actor\n"
            + "2 <genre>                    Filter movies by genre\n"
            + "3 <year> <year>              Filter movies by date range\n"
            + "4                            Exit\n\n";

const printMovie = (movie) => {
    console.log('title: ' + movie.title + '\n' +
        'year: ' + movie.year + '\n' +
        'genre: ' + movie.genre + '\n' +
        'cast: ' + movie.cast + '\n');
}


const getMoviesByActor = (userInput) => {
    const moviesByActor = parsedData.filter(movie => {
        if(movie.cast !== null) {
            return movie.cast.indexOf(userInput) !== -1;
        }
        return false;
    });
    return moviesByActor;
}

const getMoviesWithGenre = (userInput) => {
    const moviesByGenre = parsedData.filter(movie => {
        if(movie.genre !== null) {
            return movie.genre.indexOf(userInput) !== -1;
        }
        return false;
    });
    return moviesByGenre;
}

const getMoviesByTimeFrame = (toYear, fromYear) => {
    const moviesByTimeFrame = parsedData.filter(movie => {
        if(movie.year !== null) {
            return (toYear <= movie.year) && (movie.year <= fromYear);
        }
        return false;
    });
    return moviesByTimeFrame;
}

//Main application method
const appController = () => {
    rl.question(menu, (line) => {

        const option = line.slice(0,1);
		const userInput = line.slice(2);

		switch (option) {
		    case "1":
                const moviesWithActor = getMoviesByActor(userInput);
		        moviesWithActor.forEach(movie => {
                    printMovie(movie);
		        });
		        break;
            case "2":
                const moviesWithGenre = getMoviesWithGenre(userInput);
                moviesWithGenre.forEach(movie => {
                    printMovie(movie);
                });
                break;
            case "3":
                const toYear = userInput.split(' ')[0];
                const fromYear  = userInput.split(' ')[1];
                const moviesInTimeRange = getMoviesByTimeFrame(toYear, fromYear);
                moviesInTimeRange.forEach(movie => {
                    printMovie(movie);
                });
                break;
                case "4":
                    return rl.close();
                default:
                    console.log("No such option. Please enter another: ");
		}
		appController();
    });
};

const parsedData = loadFileAndParseToJsonObj();
appController();