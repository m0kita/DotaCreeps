package ru.mokita.dotacreeps.presentation.heroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import ru.mokita.dotacreeps.databinding.FragmentHeroesBinding
import ru.mokita.dotacreeps.presentation.heroes.adapter.HeroesAdapter
import ru.mokita.dotacreeps.presentation.main.MainViewModel

@AndroidEntryPoint
class HeroesFragment : Fragment() {

    private var _binding: FragmentHeroesBinding? = null
    val binding get() = _binding!!

    private val viewModel: HeroesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            viewModel.heroes.collect{
                setupRecycler()
            }
        }
    }

    private fun setupRecycler() {
        binding.rvHeroes.adapter = HeroesAdapter(viewModel.heroes.value, requireContext())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}