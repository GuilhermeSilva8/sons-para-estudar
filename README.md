# Sons para Estudar

<img src="https://user-images.githubusercontent.com/56845163/169066193-4ec44355-cb41-4cc1-ac35-b6bbe69d4d9b.jpg" width="260"> <img src="https://user-images.githubusercontent.com/56845163/169066211-46aa5cd2-7ec7-416e-8e46-f5b3ef111a37.jpg" width="260"> <img src="https://user-images.githubusercontent.com/56845163/169066230-9b760a23-56e2-4c77-b7c3-eda8913ddcfe.jpg" width="260"> 
<img src="https://user-images.githubusercontent.com/56845163/169066239-74645b5b-a0ab-4da5-a35a-c5beda3f1efa.jpg" width="260"> <img src="https://user-images.githubusercontent.com/56845163/169066255-8aeace31-3562-4bf6-89ea-537f9b8b02b5.jpg" width="260"> <img src="https://user-images.githubusercontent.com/56845163/169066268-de084bb2-69fe-42bc-936c-af55fbca4680.jpg" width="260">

# Sobre este Projeto

A ideia do App é permitir maior concentração nos estudos através de músicas instrumentais.

# Por que?

Esse projeto faz parte do meu portifólio pessoal, então todo feedback é bem-vindo sobre o design, a estrutura, o código e qualquer coisa que você acredite que possa me tornar um desenvolvedor melhor.

Email: guilhermecsilva8@gmail.com

# Instalação

Para testar o app no seu dispositivo Android, basta baixar o APK pelo link abaixo:

[Sons para Estudar.apk](https://drive.google.com/file/d/1tYpbskWRb85-Tofrc-xmONcbDr3YDzN6/view?usp=sharing)

# Funcionalidades

- Existem 7 categorias de música(Ambient, Drum & Bass, Experimental, House, Pop, R&B e Trap/Hip-Hop) cada uma com seu número individual de músicas.
  - Navegação entre as categorias pode ser feita clicando nas abas ou rolando a tela no espaço onde as músicas são mostradas.
  - O espaço onde as abas são mostradas também permite rolagem mas não faz a troca de categoria.

- Ao clicar em uma música o MusicPlayer inicia e o nome da música é mostrado no player embaixo da barra de progresso.
  - Ao chegar ao final de uma música a próxima da lista começa a tocar.
  - A lista de músicas da categoria da música que está tocando fica em loop, a partir do momento que a última música da lista chega ao fim, então a primeira começa a tocar novamente. 
  - Quando o app é minimizado o player continua tocando, mas não há forma de pausar ou trocar de música sem estar com ele aberto.

- Botão de play/pause e barra de progresso
  - O botão aparece com o símbolo de play quando não há nenhuma música no player ou a música atual está pausada.
  - O botão aparece com o símbolo de pause quando existe uma música tocando atualmente no player.
  - A barra de progresso permite navegar pelos segundos da música.

# Ferramentas usadas

- TabLayout com ViewPager2 para criar as abas e suas respectivas categorias.
- RecyclerView em Fragments permitindo clique nos itens para as músicas.
- Uso da class MediaPlayer para tocar as músicas.
- Passagem de informações de Fragment para Acitivity por meio de Intents e Parcelable.
- Ciclo de vida de Activity e Fragment para encerrar e iniciar o player.
