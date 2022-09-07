const connection = require('./config/mongoConnection');
const bands = require('./data/bands');

const main = async () => {
    const db = await connection.dbConnection();
    await db.dropDatabase();

    /** Code Reference from assignment problem set */
    // insert a band
    // try {
    // 	const pinkFloyd = await bands.create(
    // 		'Pinky Floyd',
    // 		['Progressive Rock', 'Psychedelic rock', 'Classic Rock'],
    // 		'http://www.pinkfloyd.com',
    // 		'EMI',
    // 		[
    // 			'Roger Waters',
    // 			'David Gilmour',
    // 			'Nick Mason',
    // 			'Richard Wright',
    // 			'Sid Barret',
    // 		],
    // 		1965
    // 	);
    // 	console.log(pinkFloyd);
    // } catch (e) {
    // 	console.log(e);
    // }

    // get all bands

    // try {
    // 	const allBands = await bands.getAll();
    // 	console.log(allBands);
    // } catch (e) {
    // 	console.log(e);
    // }

    // get a particular band based on id

    // try {
    // 	const bandDetail = await bands.get('6208a231edee75af2dae45ab');
    // 	console.log(bandDetail);
    // } catch (e) {
    // 	console.log(e);
    // }

    // remove using id
    // try {
    // 	const removeBeatles = await bands.remove('6208a231edee75af2dae45ab');
    // 	console.log(removeBeatles);
    // } catch (e) {
    // 	console.log(e);
    // }

    //rename band
    // const renamedBeatles = await bands.rename(
    // 	'6208a2360dd2dfbcd47766cf',
    // 	'Deep Manek'
    // );
    // console.log(renamedBeatles);

    // await connection.closeConnection();
    //	console.log('Done!');



    let sanam = undefined;
    let hansZimmer = undefined;
    try {
        sanam = await bands.create(
            'Sanam Music',
            ['Old Bollywood', '90s Music', 'Classical', 'Old Bollywood Remix'],
            'http://www.sanammusic.com',
            'Tseries',
            [
                'Sanam Puri',
                'AR Rahman',
                'Lata Mangeshkar',
                'sonu Nigam',
                'Ankit Tiwari',
            ],
            1963
        );
        console.log(sanam);
    } catch (e) {
        console.log(e);
    }

    try {
        avicii = await bands.create(
            'avicii',
            ['Instrumental', 'Background Music', 'Sun Burn'],
            'http://www.avicii.com',
            'Pewdiepie',
            ['Avicii - Tim Bergling'],
            2001
        );
    } catch (e) {
        console.log(e);
    }

    try {
        const allBands = await bands.getAll();
        console.log(allBands);
    } catch (e) {
        console.log(e);
    }

    try {
        const removeavicii = await bands.remove(avicii._id);
        console.log(removeavicii);
    } catch (e) {
        console.log(e);
    }

    //rename band that does not exist

    try {
        const renameColdPlay = await bands.rename('fakeid', 'Cold Play Reloaded');
        console.log('Rename happened');
        console.log(renameColdPlay);
    } catch (e) {
        console.log('Rename happened');
        console.log(e);
    }

    try {
        const renamedSanam = await bands.rename(
            sanam._id.toString(),
            'Sanam Reloaded'
        );
        console.log(renamedSanam);
    } catch (e) {
        console.log(e);
    }

    //get band whose id does not exist
    try {
        const bandDetail = await bands.get('6201a231edee75af2dae45ac');
        console.log(bandDetail);
    } catch (e) {
        console.log(e);
    }

    //checking whether there's an error
    console.log('OUTPUT:::::::::::::' + sanam);
    try {
        const bandDetail = await bands.get(sanam._id.toString());

        console.log(bandDetail);
    } catch (e) {
        console.log('Error found in Lab 04 work');
        console.log(e);
    }

    //closing database connection
    await connection.closeConnection();
};

main();