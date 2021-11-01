import Chart from 'react-apexcharts';

function BarChart() {

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  const mockData = {
    labels: {
      categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    },
    series: [
      {
        name: "% Sucesso",
        data: [43.6, 67.1, 67.7, 45.6, 71.1]
      }
    ]
  };


  return (

    // Temos que passar os argumentos do Chart/grafico
    <Chart

      // Quando usamos o ... estamos falando para ele pegar tudo que estiver dentro dele.
      // O xaxis é o eixo X e estamos pegando a função mockData. 
      options={{ ...options, xaxis: mockData.labels }}

      // Passando os valores.
      series={mockData.series}

      // Tipo
      type="bar"

      // Tamanho
      height="240"

    />

  );
}

export default BarChart;
