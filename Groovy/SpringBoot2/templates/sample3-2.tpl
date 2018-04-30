html{
	head{
		title('index page')
	}

	body{
		h1('Hello World !!!')
		p('This is Groovy template.')
		div(){
			a(href: '#'){
				yield 'Link blank'
			}
		}
	}
}
