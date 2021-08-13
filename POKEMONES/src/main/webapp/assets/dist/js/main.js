$('[id^="btn-delete"]').click(function() {
    let code = $(this).attr('data-code');
    let text = $(this).attr('data-text');

    $('#id').val(code);
    $('#text-delete').text(text);
});

$('[id^="btn-details"]').click(function(){
    let id = $(this).attr('data-code');

    $.ajax({
        type: 'POST',
        url: 'https://pokeapi.co/api/v2/pokemon?limit=50&offset=100',
        data: {
            action: 'findAll',
            results: pokemon_favorito
        }
    }).done(function(res){
        console.log(res);
        let pokemon = res.pokemon;

        $('#lbl_nombre').text(pokemon.nombre.nombre);
        $('#lbl_primer_apellido').text(pokemon.nombre.primer_apellido);
        $('#lbl_segundo_apellido').text(pokemon.nombre.segundo_apellido);
        $('#lbl_pokemon_favorito').text(pokemon.nombre.Pokemon_favorito);
    });
});